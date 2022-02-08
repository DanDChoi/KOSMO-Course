package bitcinema.mvc.model;

public class DTO
{
	private int film_id;
	private String film_title;
	private String film_title_eng;
	private String film_content;
	private String genre_name;
	private String material_name;
	private int director_id;
	private String director_name;
	private int actor_id1;
	private int actor_id2;
	private int actor_id3;
	private String actor_name1;
	private String actor_name2;
	private String actor_name3;
	private String film_poster;
	private float film_grade_naver;
	private float film_grade_bit;
	private int running_time;
	
	private String review_writer;
	private String review_content;
	private String review_writedate;
	private float review_grade;
	
	int curating_no;
	String curating_subject;
	String curating_content;
	String curating_writedate;
	String youtubeurl;
	
	public DTO() {}

	// Main
	public DTO(int film_id, String film_title, String film_title_eng, String film_content, String genre_name,
			String material_name, String director_name, String actor_name1, String actor_name2, String actor_name3,
			String film_poster, float film_grade_naver, float film_grade_bit, int running_time) {
		this.film_id = film_id;
		this.film_title = film_title;
		this.film_title_eng = film_title_eng;
		this.film_content = film_content;
		this.genre_name = genre_name;
		this.material_name = material_name;
		this.director_name = director_name;
		this.actor_name1 = actor_name1;
		this.actor_name2 = actor_name2;
		this.actor_name3 = actor_name3;
		this.film_poster = film_poster;
		this.film_grade_naver = film_grade_naver;
		this.film_grade_bit = film_grade_bit;
		this.running_time = running_time;
	}

	// Film Detail
	public DTO(int film_id, String film_title, String film_title_eng, String film_content, String genre_name,
			String material_name, int director_id, String director_name, int actor_id1, int actor_id2, int actor_id3,
			String actor_name1, String actor_name2, String actor_name3, String film_poster, float film_grade_naver,
			float film_grade_bit, int running_time) {
		this.film_id = film_id;
		this.film_title = film_title;
		this.film_title_eng = film_title_eng;
		this.film_content = film_content;
		this.genre_name = genre_name;
		this.material_name = material_name;
		this.director_id = director_id;
		this.director_name = director_name;
		this.actor_id1 = actor_id1;
		this.actor_id2 = actor_id2;
		this.actor_id3 = actor_id3;
		this.actor_name1 = actor_name1;
		this.actor_name2 = actor_name2;
		this.actor_name3 = actor_name3;
		this.film_poster = film_poster;
		this.film_grade_naver = film_grade_naver;
		this.film_grade_bit = film_grade_bit;
		this.running_time = running_time;
	}
		
	// Review List
	public DTO(int film_id, String review_writer, String review_content, String review_writedate, float review_grade) {
		this.film_id = film_id;
		this.review_writer = review_writer;
		this.review_content = review_content;
		this.review_writedate = review_writedate;
		this.review_grade = review_grade;
	}
	
	// Search
	public DTO(String film_title) {
		this.film_title = film_title;
	}

	// Curating board
	public DTO(int curating_no, String curating_subject, String curating_content, String curating_writedate, String youtubeurl) {
		this.curating_no = curating_no;
		this.curating_subject = curating_subject;
		this.curating_content = curating_content;
		this.curating_writedate = curating_writedate;
		this.youtubeurl = youtubeurl;
	}
	
	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getFilm_title() {
		return film_title;
	}

	public void setFilm_title(String film_title) {
		this.film_title = film_title;
	}

	public String getFilm_title_eng() {
		return film_title_eng;
	}

	public void setFilm_title_eng(String film_title_eng) {
		this.film_title_eng = film_title_eng;
	}

	public String getFilm_content() {
		return film_content;
	}

	public void setFilm_content(String film_content) {
		this.film_content = film_content;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

	public String getMaterial_name() {
		return material_name;
	}

	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}

	public String getDirector_name() {
		return director_name;
	}

	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}

	public String getActor_name1() {
		return actor_name1;
	}

	public void setActor_name1(String actor_name1) {
		this.actor_name1 = actor_name1;
	}

	public String getActor_name2() {
		return actor_name2;
	}

	public void setActor_name2(String actor_name2) {
		this.actor_name2 = actor_name2;
	}

	public String getActor_name3() {
		return actor_name3;
	}

	public void setActor_name3(String actor_name3) {
		this.actor_name3 = actor_name3;
	}

	public String getFilm_poster() {
		return film_poster;
	}

	public void setFilm_poster(String film_poster) {
		this.film_poster = film_poster;
	}

	public float getFilm_grade_naver() {
		return film_grade_naver;
	}

	public void setFilm_grade_naver(float film_grade_naver) {
		this.film_grade_naver = film_grade_naver;
	}

	public float getFilm_grade_bit() {
		return film_grade_bit;
	}

	public void setFilm_grade_bit(float film_grade_bit) {
		this.film_grade_bit = film_grade_bit;
	}

	public int getRunning_time() {
		return running_time;
	}

	public void setRunning_time(int running_time) {
		this.running_time = running_time;
	}

	public int getDirector_id() {
		return director_id;
	}

	public void setDirector_id(int director_id) {
		this.director_id = director_id;
	}

	public int getActor_id1() {
		return actor_id1;
	}

	public void setActor_id1(int actor_id1) {
		this.actor_id1 = actor_id1;
	}

	public int getActor_id2() {
		return actor_id2;
	}

	public void setActor_id2(int actor_id2) {
		this.actor_id2 = actor_id2;
	}

	public int getActor_id3() {
		return actor_id3;
	}

	public void setActor_id3(int actor_id3) {
		this.actor_id3 = actor_id3;
	}

	public String getReview_writer() {
		return review_writer;
	}

	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_writedate() {
		return review_writedate;
	}

	public void setReview_writedate(String review_writedate) {
		this.review_writedate = review_writedate;
	}

	public float getReview_grade() {
		return review_grade;
	}

	public void setReview_grade(float review_grade) {
		this.review_grade = review_grade;
	}

	public int getCurating_no() {
		return curating_no;
	}

	public void setCurating_no(int curating_no) {
		this.curating_no = curating_no;
	}

	public String getCurating_subject() {
		return curating_subject;
	}

	public void setCurating_subject(String curating_subject) {
		this.curating_subject = curating_subject;
	}

	public String getCurating_content() {
		return curating_content;
	}

	public void setCurating_content(String curating_content) {
		this.curating_content = curating_content;
	}

	public String getCurating_writedate() {
		return curating_writedate;
	}

	public void setCurating_writedate(String curating_writedate) {
		this.curating_writedate = curating_writedate;
	}

	public String getYoutubeurl() {
		return youtubeurl;
	}

	public void setYoutubeurl(String youtubeurl) {
		this.youtubeurl = youtubeurl;
	}
}