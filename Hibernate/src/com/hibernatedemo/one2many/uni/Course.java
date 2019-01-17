package com.hibernatedemo.one2many.uni;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="courses")
public class Course implements Serializable {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="name")
		private String name;
		
		@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, 
							 CascadeType.PERSIST, CascadeType.REFRESH})
		@JoinColumn(name="instructor_id")
		private Instructor instructor;
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="course_id")
		private List<Review> reviews;

		public Course() {
		}

		public String getName() {
			return name;
		}

		public Course(String name) {
			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Instructor getInstructor() {
			return instructor;
		}

		public void setInstructor(Instructor instructor) {
			this.instructor = instructor;
		}

		public List<Review> getReviews() {
			return reviews;
		}

		public void setReviews(List<Review> reviews) {
			this.reviews = reviews;
		}
		
		public void addReview(Review theReview) {
			if(reviews == null) {
				reviews = new ArrayList<Review>();
			}
			reviews.add(theReview);
		}
		@Override
		public String toString() {
			return "Course [id=" + id + ", name=" + name + ", instructor=" + instructor + ", reviews=" + reviews + "]";
		}
		
		
		
		
}
