package com.wipro.training3.coursedetails.entity;

import java.time.LocalDateTime;

public class BaseEntity {
   private LocalDateTime updatedTs;
   private LocalDateTime createTs = LocalDateTime.now();
public LocalDateTime getUpdatedTs() {
	return updatedTs;
}
public void setUpdatedTs(LocalDateTime updatedTs) {
	this.updatedTs = updatedTs;
}
public LocalDateTime getCreateTs() {
	return createTs;
}
public void setCreateTs(LocalDateTime createTs) {
	this.createTs = createTs;
}
   
}
