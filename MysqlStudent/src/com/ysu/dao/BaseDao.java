package com.ysu.dao;


import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ysu.annotation.Column;
import com.ysu.annotation.Table;
import com.ysu.entity.BaseEntity;
import com.ysu.page.Operator;
import com.ysu.page.Page;
import com.ysu.page.SearchProperty;
import com.ysu.util.DbUtil;
import com.ysu.util.StringUtil;
/*
 * ������dao,�����װ���еĲ���
 * 
 */
public class BaseDao<T> {
	//����ģʽ����һ������ֻ����һ��ʵ���������ж��
	private DbUtil dbUtil = DbUtil.getInstance();//��������
	//public Connection connection = dbUtil.getConnection();//��������
	private final static int CURD_ADD = 0;
	private final static int CURD_UPDATE = 1;
	private final static int CURD_FIND = 2;
	private final static int CURD_SELECT = 3;
	private final static int CURD_DELETE = 4;
	private final static int CURD_COUNT = 5;
	private Class<T> t;
	
	public BaseDao() {
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		if(genericSuperclass instanceof ParameterizedType) {
			Type[] actualTypeArguments = ((ParameterizedType)genericSuperclass).getActualTypeArguments();
			if(actualTypeArguments != null && actualTypeArguments.length>0) {
				t =(Class<T>) actualTypeArguments[0];
			}
		}
	}
	
	/*
	 * �����װ���ݿ����Ӳ���
	 */
	//���Ӳ���
	public boolean add(T t) {
		
		String sql = buildSql(CURD_ADD);
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			prepareStatement = setPreparedStatement(t,prepareStatement,CURD_ADD);
			int rst =  prepareStatement.executeUpdate();
			dbUtil.releaseConnection();
			return rst> 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}
	
	/*
	 * ���ݿ���²��������װ
	 */
	public boolean update(T t) {
		String sql = buildSql(CURD_UPDATE);
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			prepareStatement = setPreparedStatement(t,prepareStatement,CURD_UPDATE);
			int rst =  prepareStatement.executeUpdate();
			dbUtil.releaseConnection();
			return rst> 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * ���ݿ��ѯ����ʵ������ֶ�
	 */
	public T find(int id) {
		String sql = buildSql(CURD_FIND);
		T newInstance = null;
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			prepareStatement.setObject(1, id);
			ResultSet executeQuery = prepareStatement.executeQuery();
			if(executeQuery.next()) {
				newInstance = (T) t.newInstance();
				newInstance = setParams(newInstance,executeQuery);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbUtil.releaseConnection();
		return newInstance;
	}
	
	/*
	 * �����װ����������ҳ��ѯ�б�����
	 */
	public Page<T> findList(Page<T> page){
		String sql = buildSql(CURD_SELECT);
		sql += buildSearchSql(page);
		sql += " limit " + page.getOffset() + "," + page.getPageSize();
		
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			prepareStatement = setSearchPropareStatement(prepareStatement,page);
			ResultSet executeQuery = prepareStatement.executeQuery();
			while(executeQuery.next()) {
				T newInstance = (T) t.newInstance();
				newInstance = setParams(newInstance,executeQuery);
				page.getContent().add(newInstance);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.setTotal(getTotal(buildSql(CURD_COUNT) + buildSearchSql(page),page));
		int totalPage = 0;
		if(page.getTotal() % page.getPageSize() == 0) {
			totalPage = page.getTotal() / page.getPageSize();
		}else {
			totalPage = page.getTotal() / page.getPageSize() + 1;
		}
		page.setTotalPage(totalPage);
		dbUtil.releaseConnection();
		return page;
	}
	
	
	/*
	 * �����װɾ��������֧�ֵ���ɾ��������ɾ��
	 */
	public boolean delete(int... ids) {
		String sql = buildSql(CURD_DELETE);
		String idsStr = "";
		for(int i = 0;i<ids.length;i++) {
			idsStr += ids[i] + ",";
		}
		if(!"".equals(idsStr)) {
			idsStr = idsStr.substring(0,idsStr.length()-1);
		}
		sql = sql.replace("?",idsStr);
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			int rst =  prepareStatement.executeUpdate();
			dbUtil.releaseConnection();
			return rst> 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * �����ܵļ�¼��
	 */
	private int getTotal(String sql,Page<T> page) {
		PreparedStatement prepareStatement;
		try {
			prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			prepareStatement = setSearchPropareStatement(prepareStatement,page);
			ResultSet executeQuery = prepareStatement.executeQuery();
			if(executeQuery.next()) {
				int total = executeQuery.getInt("total");
				dbUtil.releaseConnection();
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	/*
	 * ��������ϲ�ѯ
	 */
	private PreparedStatement setSearchPropareStatement(
			PreparedStatement prepareStatement, Page<T> page) {
		List<SearchProperty> searchProporties = page.getSearchProporties();
		int index = 1;
		
		for(SearchProperty searchProporty: searchProporties) {
			try {
				if(searchProporty.getOperator() != Operator.IN) {
					prepareStatement.setObject(index++,searchProporty.getValue());
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return prepareStatement;
	}

	/*
	 * �����������ѯ������sql���
	 */
	private String buildSearchSql(Page<T> page) {
		String searchSql = "";
		List<SearchProperty> searchProporties = page.getSearchProporties();
		for(SearchProperty searchProperty: searchProporties) {
			switch(searchProperty.getOperator()) {
				case GT:{//����
					searchSql += " and " + searchProperty.getKey() + " > ?";
					break;
				}
				case GTE:{//���ڵ���
					
					searchSql += " and " + searchProperty.getKey() + " >= ?";
					break;
				}
				case EQ:{//����
					
					searchSql += " and " + searchProperty.getKey() + " = ?";
					break;
				}
				case LT:{//С��
					
					searchSql += " and " + searchProperty.getKey() + " < ?";
					break;
				}
				case LTE:{//С�ڵ���
					
					searchSql += " and " + searchProperty.getKey() + " <= ?";
					break;
				}
				case NEQ:{//������
					
					searchSql += " and " + searchProperty.getKey() + " <> ?";
					break;
				}
				case LIKE:{//ģ��ƥ��
					
					searchSql += " and " + searchProperty.getKey() + " like ?";
					break;
				}
				case IN:{//�ڷ�Χ��
					
					searchSql += " and " + searchProperty.getKey() + " in(" + searchProperty.getValue() + ")";
					break;
				}
			}
		}
		if(!"".equals(searchSql)) {
			searchSql = searchSql.replaceFirst("and", "where");
		}
		return searchSql;
	}

	/*
	 * �������ݿ��ȡ�����ݸ�ֵ����ʵ����
	 */
	private T setParams(T newInstance, ResultSet executeQuery) {
		//���Ȼ�ȡ����������ֶ�
		Field[] declaredFields = newInstance.getClass().getDeclaredFields();
		try {
			for(Field field:declaredFields) {
				field.setAccessible(true);
				if(field.isAnnotationPresent(Column.class)) {
					Column annotation = field.getAnnotation(Column.class);
					if(!annotation.isForeignEntity()) {
						//��������Զ������
						field.set(newInstance, executeQuery.getObject(annotation.name()));
					}else {
						Blob blob = executeQuery.getBlob(annotation.name());
						ObjectInputStream objectInputStream = new ObjectInputStream(blob.getBinaryStream());
						field.set(newInstance, objectInputStream.readObject());
					}
				}else {
					field.set(newInstance, executeQuery.getObject(StringUtil.convertToUnderline(field.getName())));
					
				}
				
			}
			
			Field[] parentFields = newInstance.getClass().getFields();
			for(Field field:parentFields) {
				field.setAccessible(true);
				if(field.isAnnotationPresent(Column.class)) {
					Column annotation = field.getAnnotation(Column.class);
					field.set(newInstance, executeQuery.getObject(annotation.name()));
				}else {
					field.set(newInstance, executeQuery.getObject(StringUtil.convertToUnderline(field.getName())));
					
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return newInstance;
	}

	/*
	 * �������ݿ�������Ϣ���ֵ������ֵ������
	 */
	private PreparedStatement setPreparedStatement(T t,PreparedStatement prepareStatement,int curdType) {
		Field[] declaredFields = t.getClass().getDeclaredFields();
		try {
			switch(curdType) {
			case CURD_ADD:{
				
				int index = 1;
				for(int i = 0; i<declaredFields.length;i++) {
					declaredFields[i].setAccessible(true);
					//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
					//��Ϊ����ʱ����Ҫ��ֵ
					if(declaredFields[i].isAnnotationPresent(Column.class)) {
						Column annotation = declaredFields[i].getAnnotation(Column.class);
						if(!annotation.autoIncrease()) {
							//����ʱ�丳ֵĬ��
							if(annotation.autoCreateTime()) {
								declaredFields[i].set(t, new Timestamp(System.currentTimeMillis()));
							}
							prepareStatement.setObject(index++, declaredFields[i].get(t));
							continue;
						}
					}else if(!"id".equals(declaredFields[i].getName())){
						prepareStatement.setObject(index++, declaredFields[i].get(t));
					}
					
				}
				if(BaseEntity.class.isAssignableFrom(t.getClass())) {
					//���̳��˻���
					Field[] fields = t.getClass().getFields();
					
					for(int i = 0; i<fields.length;i++) {
						fields[i].setAccessible(true);
						
						
						//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
						//��Ϊ����ʱ����Ҫ��ֵ
						if(fields[i].isAnnotationPresent(Column.class)) {
							Column annotation = fields[i].getAnnotation(Column.class);
							if(!annotation.autoIncrease()) {
								//����ʱ�丳ֵĬ��
								if(annotation.autoCreateTime()) {
									fields[i].set(t, new Timestamp(System.currentTimeMillis()));
								}
								prepareStatement.setObject(index++, fields[i].get(t));
								continue;
							}
						}else if(!"id".equals(fields[i].getName())) {
							prepareStatement.setObject(index++, fields[i].get(t));
						}
						
					}
				}
				break;
			}
			case CURD_UPDATE:{
				int index = 1;
				for(Field field : declaredFields) {
					field.setAccessible(true);
					//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
					//��Ϊ����ʱ����Ҫ��ֵ
					if(field.isAnnotationPresent(Column.class)) {
						Column annotation = field.getAnnotation(Column.class);
						//�����������ҿ��Ը���
						if(!annotation.primaryKey() && annotation.updateEnable()) {
							prepareStatement.setObject(index++, field.get(t));
						}
					}else {
						if(!"id".equals(field.getName())) {
							prepareStatement.setObject(index++, field.get(t));
						}
					}
				}
				if(BaseEntity.class.isAssignableFrom(t.getClass())) {
					//���̳��˻���
					Field[] parentFields = t.getClass().getFields();
					
					for(int i = 0; i<parentFields.length;i++) {
						parentFields[i].setAccessible(true);
						//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
						//��Ϊ����ʱ����Ҫ��ֵ
						if(parentFields[i].isAnnotationPresent(Column.class)) {
							Column annotation = parentFields[i].getAnnotation(Column.class);
							//�����������ҿ��Ը���
							if(!annotation.primaryKey() && annotation.updateEnable()) {
								prepareStatement.setObject(index++, parentFields[i].get(t));
							}
							
						}else {
							if(!"id".equals(parentFields[i].getName())) {
								prepareStatement.setObject(index++, parentFields[i].get(t));
							}
						}
						
					}
				}
				//��������
				for(Field field : declaredFields) {
					field.setAccessible(true);
					//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
					//��Ϊ����ʱ����Ҫ��ֵ
					if(field.isAnnotationPresent(Column.class)) {
						Column annotation = field.getAnnotation(Column.class);
						//���������ҿ��Ը���
						if(annotation.primaryKey()) {
							prepareStatement.setObject(index++, field.get(t));
						}
					}else {
						if("id".equals(field.getName())) {
							prepareStatement.setObject(index++, field.get(t));
						}
					}
				}
				if(BaseEntity.class.isAssignableFrom(t.getClass())) {
					//���̳��˻���
					Field[] parentFields = t.getClass().getFields();
					
					for(int i = 0; i<parentFields.length;i++) {
						parentFields[i].setAccessible(true);
						//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
						//��Ϊ����ʱ����Ҫ��ֵ
						if(parentFields[i].isAnnotationPresent(Column.class)) {
							Column annotation = parentFields[i].getAnnotation(Column.class);
							//�����������ҿ��Ը���
							if(annotation.primaryKey()) {
								prepareStatement.setObject(index++, parentFields[i].get(t));
							}
							
						}else {
							if("id".equals(parentFields[i].getName())) {
								prepareStatement.setObject(index++, parentFields[i].get(t));
							}
						}
						
					}
				}
				break;
			}
			case CURD_FIND:{
				
				break;
			}
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepareStatement;
	}
	/*
	 * ����sql���
	 */
	private String buildSql(int curdType) {
		String sql = "";
		switch(curdType) {
			case CURD_ADD:{
				sql = "insert into "+getTableName() +"("+getAddTableFields()+") values("+getAddTableValues()+")";
				break;
			}
			case CURD_UPDATE:{
				sql = "update "+getTableName() +" set "+getUpdateTableParams();
				break;
			}
			case CURD_FIND:{
				sql = "select * from "+getTableName() +" where "+getFindSingleParams();
				break;
			}
			case CURD_SELECT:{
				sql = "select * from "+getTableName();
				break;
			}
			case CURD_DELETE:{
				sql = "delete from "+getTableName() + " where id in(?) ";
				break;
			}
			case CURD_COUNT:{
				sql = "select count(*) as total from " + getTableName();
				break;
			}
		}
		System.out.println(sql);
		return sql;
	}
	
	/*
	 * ��ȡ����ʵ����ֶ�Ԥ���
	 */
	private String getFindSingleParams() {
		//���ȴ��Լ����ֶ��л�ȡ����
		Field[] declaredFields = t.getDeclaredFields();
		String where = "";
		for(Field field : declaredFields) {
			//���ֶα�ע��
			if(field.isAnnotationPresent(Column.class)) {
				Column annotation = field.getAnnotation(Column.class);
				if(annotation.primaryKey()) {
					where = annotation.name() + " = ?";
					break;
				}
			}else {
				if("id".equals(field.getName())) {
					where = " id = ?";
				}
			}
		}
		//���̳��˸���
		if(BaseEntity.class.isAssignableFrom(t)) {
			//���̳��˻���
			Field[] fields = t.getFields();
			for(Field field : fields) {
				//���ֶα�ע��
				if(field.isAnnotationPresent(Column.class)) {
					Column annotation = field.getAnnotation(Column.class);
					if(annotation.primaryKey()) {
						where = annotation.name() + " = ?";
						break;
					}
				}else {
					if("id".equals(field.getName())) {
						where = " id = ?";
						break;
					}
				}
			}
		}
		return where;
	}

	/*
	 * ��ȡ���²���ʱ���ֶ�Ԥ���ֵ
	 */
	private String getUpdateTableParams() {
		//��ȡ�Լ�����������ֶ�
		Field[] declaredFields = t.getDeclaredFields();
		String params = "";
		String where = " ";
		for(Field field : declaredFields) {
			field.setAccessible(true);
			//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
			//��Ϊ����ʱ����Ҫ��ֵ
			if(field.isAnnotationPresent(Column.class)) {
				Column annotation = field.getAnnotation(Column.class);
				//�����������ҿ��Ը���
				if(!annotation.primaryKey() && annotation.updateEnable()) {
					params += annotation.name() + "=?,";
				}
				if(annotation.primaryKey()) {
					where += "and " + annotation.name() + " = ? ";
				}
			}else {
				if(!"id".equals(field.getName())) {
					params += StringUtil.convertToUnderline(field.getName()) + "=?,";
				}else{
					where += "and " + StringUtil.convertToUnderline(field.getName())  + " = ? ";
				}
			}
		}
		if(BaseEntity.class.isAssignableFrom(t)) {
			//���̳��˻���
			Field[] parentFields = t.getFields();
			
			for(int i = 0; i<parentFields.length;i++) {
				parentFields[i].setAccessible(true);
				//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
				//��Ϊ����ʱ����Ҫ��ֵ
				if(parentFields[i].isAnnotationPresent(Column.class)) {
					Column annotation = parentFields[i].getAnnotation(Column.class);
					//�����������ҿ��Ը���
					if(!annotation.primaryKey() && annotation.updateEnable()) {
						params += annotation.name() + "=?,";
					}
					if(annotation.primaryKey()) {
						where += "and " + annotation.name() + " = ? ";
					}
				}else {
					if(!"id".equals(parentFields[i].getName())) {
						params += StringUtil.convertToUnderline(parentFields[i].getName()) + "=?, ";
					}else{
						where += "and " + StringUtil.convertToUnderline(parentFields[i].getName()) + " = ?";
					}
				}
				
			}
		}
		where = where.substring(0,where.length()-1).replaceFirst("and", "where ");
		return params.substring(0,params.length()-1) + where;
	}

	/*
	 * ��ȡ���Ӳ���ʱ���ֶ�Ԥ���ֵ
	 */
	private String getAddTableValues() {
		List<String> fields = getTableFields();
		String[] values = new String[fields.size()];
		Arrays.fill(values, "?");
		for(int i = 0;i<values.length;i++) {
			
			
		}
		Field[] declaredFields = t.getDeclaredFields();
		for(int i = 0; i<declaredFields.length;i++) {
			declaredFields[i].setAccessible(true);
			//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
			//��Ϊ����ʱ����Ҫ��ֵ
			if(declaredFields[i].isAnnotationPresent(Column.class)) {
				Column annotation = declaredFields[i].getAnnotation(Column.class);
				if(annotation.autoIncrease()) {
					values[i] = "null";
				}
			}else {
				if("id".equals(declaredFields[i].getName())) {
					values[i] = "null";
				}
			}
		}
		if(BaseEntity.class.isAssignableFrom(t)) {
			//���̳��˻���
			Field[] parentFields = t.getFields();
			
			for(int i = 0; i<parentFields.length;i++) {
				parentFields[i].setAccessible(true);
				//���������ע���ֶΣ�����ע���ֶ��Ƿ�Ϊ����
				//��Ϊ����ʱ����Ҫ��ֵ
				if(parentFields[i].isAnnotationPresent(Column.class)) {
					Column annotation = parentFields[i].getAnnotation(Column.class);
					if(annotation.autoIncrease()) {
						values[declaredFields.length + i] = "null";
					}
				}else {
					if("id".equals(parentFields[i].getName())) {
						values[i] = "null";
					}
				}
				
			}
		}
		return StringUtil.join(Arrays.asList(values), ",");
	}
	/*
	 * ��ȡ���Ӳ�����ʵ���ֶ�
	 */
	private String getAddTableFields() {
		List<String> fields = getTableFields();
		
		return StringUtil.join(fields, ",");
	}
	/*
	 * ��ȡ���ݿ���������ֶ�
	 */
	private List<String> getTableFields() {
		List<String> ret = new ArrayList<String>();
		Field[] declaredFields = t.getDeclaredFields();
		
		for(Field field:declaredFields) {
			//����ֶα�ע�⣬����ע���Ϊ��
			//System.out.println(field.getName());
			if(field.isAnnotationPresent(Column.class)) {
				ret.add(field.getAnnotation(Column.class).name());
				continue;
			}
			ret.add(StringUtil.convertToUnderline(field.getName()));
		}
		if(BaseEntity.class.isAssignableFrom(t)) {
			//˵���̳���BaseEntity
			Field[] fields = t.getFields();
			for(Field field :fields) {
				//����ֶα�ע�⣬����ע���Ϊ��
				if(field.isAnnotationPresent(Column.class)) {
					ret.add(field.getAnnotation(Column.class).name());
					continue;
				}
				ret.add(StringUtil.convertToUnderline(field.getName()));
			}
		}
		return ret;
	}
	/*
	 * ��ȡʵ���Ӧ�����ݿ����
	 */
	private String getTableName() {//��ȡ����
		String tableName =StringUtil.convertToUnderline(t.getSimpleName());
		if(t.isAnnotationPresent(Table.class)) {
			//���ע���ˣ�����ע���˵�Ϊ��
			String prefix = t.getAnnotation(Table.class).prefix();
			String sufix = t.getAnnotation(Table.class).sufix();
			tableName = StringUtil.isEmpty(prefix) ? "" : prefix + "_";
			tableName += t.getAnnotation(Table.class).tableName();
			tableName +=StringUtil.isEmpty(sufix) ? "" : "_" + sufix;
		}
		return tableName;
	}
	
	

	public void closeConnection() {//�ر�
		dbUtil.releaseConnection();
	}
}