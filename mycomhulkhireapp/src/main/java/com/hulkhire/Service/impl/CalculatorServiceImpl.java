package com.hulkhire.Service.impl;

import com.hulkhire.dto.AddRequest;
import com.hulkhire.dto.SumDTO;
import com.hulkhire.entity.SumEntity;
import com.hulkhire.repository.SumRepository;
import com.hulkhire.Service.CalculatorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private SumRepository sumRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int add(AddRequest request) {
        // Convert AddRequest to SumDTO using ModelMapper
        SumDTO dto = modelMapper.map(request, SumDTO.class);

        int result = dto.getNum1() + dto.getNum2();

        // Save to DB
        SumEntity entity = new SumEntity();
        entity.setNum1(dto.getNum1());
        entity.setNum2(dto.getNum2());
        entity.setResult(result);
        sumRepository.save(entity);

        return result;
    }
}
