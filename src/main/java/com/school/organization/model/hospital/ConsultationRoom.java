package com.school.organization.model.hospital;

import com.school.organization.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consultation_room")
public class ConsultationRoom extends BaseEntity {

    @Column(name = "room_no")
    private String roomNo;

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
}
