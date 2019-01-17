package com.hibernatedemo.one2one.uni;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail implements Serializable{

		
		@Column(name="youtube_channel")
		private String youtubeChannel;
		
		@Column(name="hobby")
		private String hobby;
		
		@Id
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="id")
		private Instructor instructor;

		public InstructorDetail() {
		}

		public InstructorDetail(String youtubeChannel, String hobby) {
			this.youtubeChannel = youtubeChannel;
			this.hobby = hobby;
		}

		public Instructor getInstructor() {
			return instructor;
		}

		public void setInstructor(Instructor instructor) {
			this.instructor = instructor;
		}

		
		public String getYoutubeChannel() {
			return youtubeChannel;
		}

		public void setYoutubeChannel(String youtubeChannel) {
			this.youtubeChannel = youtubeChannel;
		}

		public String getHobby() {
			return hobby;
		}

		public void setHobby(String hobby) {
			this.hobby = hobby;
		}
		
		
		
		
}
