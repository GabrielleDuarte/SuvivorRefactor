package com.codetest.survivor1.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codetest.survivor1.VO.SurvivorVO;
import com.codetest.survivor1.entity.Survivor;

@Configuration
public class ModelMappperConfig {
	
	@Bean 
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
		  .setFieldMatchingEnabled(true)
		  .setFieldAccessLevel(AccessLevel.PRIVATE);
		modelMapper.typeMap(SurvivorVO.class, Survivor.class).addMapping(src -> src.getLatitude(), (Survivor survivor,Long latitude) -> survivor.getLastLocation().setLatitude(latitude));
		modelMapper.typeMap(SurvivorVO.class, Survivor.class).addMapping(src -> src.getLongitude(), (Survivor survivor,Long longitude) -> survivor.getLastLocation().setLongitude(longitude));
		
		return modelMapper;
	}
	

}
