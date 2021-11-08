package users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface DTO extends JpaRepository<NewDetailsUser, Long> {

    public NewDetailsUser findByEmail(String name);

    public Optional<NewDetailsUser> findById(Long id);

}