package com.example.spring.user.user_spring.dozermapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	
	public static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public <O,D>D parseEntityForVO(O origem, Class<D> destination){
		return mapper.map(origem, destination);
	}
	
	public <O,D> List<D>parseListEntityForVO(List<O> origem, Class<D> destination){
		List<D> listParse = new ArrayList<>();
		for(O o : origem) {
			listParse.add(mapper.map(o, destination));
		}
		return listParse;
	}
}
