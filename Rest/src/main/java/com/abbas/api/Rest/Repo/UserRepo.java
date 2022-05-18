package com.abbas.api.Rest.Repo;

import com.abbas.api.Rest.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User, Long> {
}
