var mapFunc = function(){
	{	
	emit(this.sex, {weight: parseFloat(this.weight), height: parseFloat(this.height), num: 1});
	}
};

var reduceFunc = function(sex, values){
	var n = {weight: 0, height: 0, num: 0};
	for (let i = 0; i < values.length; i++) {
		n.weight += values[i].weight;
		n.height += values[i].height;
		n.num += values[i].num;
	}
	var result = "avg_weight: " + n.weight/n.num + "; avg_height: " + n.height/n.num;
	return result;
};



printjson(db.people.mapReduce(
	mapFunc,
	reduceFunc,
	{ out: {inline : 1}}
))
