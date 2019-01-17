package com.hibernatedemo.one2one.bi;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail implements Serializable{

		@Id
		@GeneratedValue(generator="gen")
	    @GenericGenerator(name="gen", strategy="foreign",parameters= {@Parameter(name="property", value="instructor")})
		@Column(name="id")
		private int id;
		
		@Column(name="youtube_channel")
		private String youtubeChannel;
		
		@Column(name="hobby")
		private String hobby;
		
		
		@OneToOne
		@PrimaryKeyJoinColumn
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

		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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
