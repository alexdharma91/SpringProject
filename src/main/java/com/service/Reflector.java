package com.service;

import com.google.common.collect.Lists;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

@Component
public class Reflector {

    public static class ClassField{
        private String name;
        private String type;

        public ClassField(String name, String type){
           this.name = name;
           this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }
    }

    @Cacheable(value="weatherCache")
    public List<ClassField> getFields(Class targetClass){
       List result = Lists.newArrayList();

       for (Field field : targetClass.getDeclaredFields()){
           boolean required = false;

           for(Annotation annotation : field.getAnnotations()){
               if(annotation.annotationType().toString().equals("interface javax.persistence.Column")){
                   required = true;
               }
           }

           if(required){
               result.add(new ClassField(field.getName(), field.getType().toString()));
           }

       }

       return result;
    }

}
