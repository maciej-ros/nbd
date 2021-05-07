var mapFunc = function(){
	{	
	emit(this.nationality, {weight: parseFloat(this.weight), height: parseFloat(this.height), num: 1});
	}
};

var reduceFunc = function(nationality, values){
	var bmis = [];
	var n = {num: 0, sum: 0};
	for (let i = 0; i < values.length; i++) {
		bmi = values[i].weight/(values[i].height**2);
		bmis.push(bmi);
		n.num += values[i].num;
		n.sum += bmi;
	}
	var result = "avg_bmi: " + n.sum/n.num + "; min_bmi: " + Math.min(...bmis) + "; max_bmi: " + Math.max(...bmis);
	return result;
};

printjson(db.people.mapReduce(
	mapFunc,
	reduceFunc,
	{ out: {inline : 1}}
))
