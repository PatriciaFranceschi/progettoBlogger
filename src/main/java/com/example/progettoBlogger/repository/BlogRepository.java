package com.example.progettoBlogger.repository;

import com.example.progettoBlogger.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Post,Long> {


}
