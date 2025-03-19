package com.example.okr.entity;
    import jakarta.persistence.*;

    @Entity
    @Table(name="users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String email;
        private String designation;
        private String managerName;
        private String role;
        private Long objectiveId;
        private Long groupId;

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getDesignation() { return designation; }
        public void setDesignation(String designation) { this.designation = designation; }
        public String getManagerName() { return managerName; }
        public void setManagerName(String managerName) { this.managerName = managerName; }
        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
        public Long getObjectiveId() { return objectiveId; }
        public void setObjectiveId(Long objectiveId) { this.objectiveId = objectiveId; }
        public Long getGroupId() { return groupId; }
        public void setGroupId(Long groupId) { this.groupId = groupId; }
    }


