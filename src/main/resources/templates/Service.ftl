package ${package}.service;

import ${pacakage}.dto.${dtoName};
import ${package}.entity.${className};

import java.util.List;
import java.util.Map;

/**
 * ${comment}
 * @author ${author}
 * @email ${email}
 * #date ${datetime}
 */
private interface ${dtoName}Service {

    ${className} get(${pk.attrType} ${pk.attrname});

    List<${className}> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(${className} ${classname});

    int update(${className} ${classname});

    int remove(${pk.attrType} ${pk.attrname});

    int batchRemove(${pk.attrType}[] ${pk.attrname}s);
}