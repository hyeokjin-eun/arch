package com.example.arch.ddd.user.service.impl;

import com.example.arch.ddd.board.service.BoardService;
import com.example.arch.ddd.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BoardService boardService;
}
