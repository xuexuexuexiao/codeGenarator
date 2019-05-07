package ${package}.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ${pacakage}.dto.${dtoName};
import ${package}.entity.${className};

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;



/**
* ${comment}
* @author ${author}
* @email ${email}
* @date ${datetime}
*/
@Service
public class ${dtoName}ServiceImpl implements ${dtoName}Service{


    @Autowired
    private ${className}Dao ${classname}Dao;

    @Override
    public ${className} get(${pk.attrType} ${pk.attrname}){
    return ${classname}Dao.get(${pk.attrname});
    }

    @Override
    public List<${className}> list(Map<String, Object> map){
    return ${classname}Dao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
    return ${classname}Dao.count(map);
    }

    @Override
    @Transactional
    public int save(${className} ${classname}){
    return ${classname}Dao.save(${classname});
    }

    @Override
    public int update(${className} ${classname}){
    return ${classname}Dao.update(${classname});
    }

    @Override
    @Transactional
    public int remove(${pk.attrType} ${pk.attrname}){
    return ${classname}Dao.remove(${pk.attrname});
    }

    @Override
    @Transactional
    public int batchRemove(${pk.attrType}[] ${pk.attrname}s){
    return ${classname}Dao.batchRemove(${pk.attrname}s);
}

}