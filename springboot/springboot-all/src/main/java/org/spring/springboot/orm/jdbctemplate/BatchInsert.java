package org.spring.springboot.orm.jdbctemplate;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;
/**
 *  BatchSqlUpdate类是SqlUpdate 的子类，适用于插入、删除、更新批量操作，内部使用PreparedStatement，所以效率很高，
 *  批量语句达到设定的batchSize，或者手动调用flush才会执行批量操作。
 *  注意：此类是非线程安全的，必须为每个使用者创建一个实例，或者在同一个线程中使用前调用reset。
 */

public class BatchInsert extends BatchSqlUpdate{
	private static final String SQL = "insert into JDBCTEMPLATE_USER (id, name,age) values (?, ?,?)";  
    
    BatchInsert(DataSource dataSource) {  
      super(dataSource, SQL);  
      declareParameter(new SqlParameter(Types.INTEGER));  
      declareParameter(new SqlParameter(Types.VARCHAR));  
      declareParameter(new SqlParameter(Types.INTEGER));  
      setBatchSize(10);  
    }  

}
