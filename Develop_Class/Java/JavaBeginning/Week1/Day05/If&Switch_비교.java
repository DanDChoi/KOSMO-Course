void cal() { //if문
	avg = total/3;
	if(avg >= 90){
		grade = "A";
	}else if(avg >= 80){
		grade = "B";
	}else if(avg >= 70){
		grade = "C";
	}else if(avg >= 60){
		grade = "D";
	}else{
		grade = "F";
	}
}


void cal(){
	avg = total/3;
	switch(avg/10){
		case 10: grade = "A"; break;
		case 9: grade = "B"; break;
		case 8: grade = "C"; break;
		case 7: grade = "D"; break;
		default : grade = "F";
	}
}