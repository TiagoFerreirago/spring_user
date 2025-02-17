package com.example.spring.user.userspring.dozermapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	
	public static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O,D>D parseEntityForVO(O origem, Class<D> destination){
		return mapper.map(origem, destination);
	}
	
	public static <O,D> List<D>parseListEntityForVO(List<O> origem, Class<D> destination){
		List<D> listParse = new ArrayList<>();
		for(O o : origem) {
			listParse.add(mapper.map(o, destination));
		}
		return listParse;
	}
}
