package com.kata.kata.dto;

import com.kata.kata.model.Account;

import java.util.List;

public record AccountDTO(Integer id, String code, String name, List<ProjectDTO> projects) {
    public static AccountDTO fromEntity(Account account) {
        List<ProjectDTO> projects = account.getProjects().stream()
                .map(ProjectDTO::fromEntity)
                .toList();
        return new AccountDTO(account.getId(), account.getAccountCode(), account.getAccountName(), projects);
    }
}
