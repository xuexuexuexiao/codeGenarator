package ${package}.entity;

import java.io.Serializable;
import java util.java;
import javax.persistence.*;
import lombok.Data;

<#if hasBigDecimal??>
import java.math.BigDecimal;
</#if>

/**
 * ${comment}
 * @author ${author}
 * @email ${email}
 * @date ${datetime}
 */
@Entity
@Table(name="${tableName}")
@Data
public class ${classname} implements Serializable{

    <#if columnDOList??>
        <#list columnDOList as column>
            /**
             * ${column.comment}
             */
             private ${column.columnType} ${column.columnName};
        </#list>
    </#if>

   <#-- <#if columnDOList??>
        <#list columnDOList as column>
            /**

        </#list>
    </#if>-->
}