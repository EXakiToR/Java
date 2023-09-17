package eshop.orm.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Entity {
    private String uuid;
    private String createdAt, readAt, updatedAt, deletedAt;
    public Entity() {
        this.uuid = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now().toString();
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    public String getReadAt() {
        return readAt;
    }
    public void setReadAt(String readAt) {
        this.readAt = readAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getDeletedAt() {
        return deletedAt;
    }
    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Entity [uuid=" + uuid + ", createdAt=" + createdAt + ", readAt=" + readAt + ", updatedAt=" + updatedAt
                + ", deletedAt=" + deletedAt + "]";
    }

    
    

}
