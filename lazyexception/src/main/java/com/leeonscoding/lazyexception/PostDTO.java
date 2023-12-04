package com.leeonscoding.lazyexception;

import java.util.List;

public record PostDTO(String title, List<Comment> comments) {
}
