package com.cocoball.jdbctest.service;

import com.cocoball.jdbctest.dao.MemberDAO;
import com.cocoball.jdbctest.domain.MemberVO;
import com.cocoball.jdbctest.dto.MemberDTO;
import com.cocoball.jdbctest.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {

        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();

    }


    public MemberDTO login(String mid, String mpw)throws Exception {

        MemberVO vo = dao.getWithPassword(mid, mpw);

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }

    public void updateUuid(String mid, String uuid)throws Exception {

        dao.updateUuid(mid, uuid);

    }

    public MemberDTO getByUUID(String uuid) throws  Exception {

        MemberVO vo = dao.selectUUID(uuid);

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }
}
