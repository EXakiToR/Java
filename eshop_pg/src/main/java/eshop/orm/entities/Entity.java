package eshop.orm.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Entity {
    private UUID uuid;
    private LocalDateTime createdAt, readAt, updatedAt, deletedAt;
    public Entity() {
        this.uuid = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getReadAt() {
        return readAt;
    }
    public void setReadAt(LocalDateTime readAt) {
        this.readAt = readAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getUuid() {
        return uuid;
    }
    
    

}
