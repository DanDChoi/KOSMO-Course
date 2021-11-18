class Cal 
{
	GradeThis g;
	void setG(GradeThis g){
		this.g = g;
	}
	void cal(){ //switch¹® 
	   g.avg = g.total/3;
       int portion = g.avg/10;
       switch (portion){
		  case 10:
		  case 9:
			 g.grade = "A";
			 break;
		  case 8:
			 g.grade = "B";
			 break;
		  case 7:
			 g.grade = "C";
			 break;
		  case 6:
			 g.grade = "D";
			 break;
		  default:
			 g.grade = "F";
        }
	}
}
