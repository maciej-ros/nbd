var mapFunc = function(){
	{	
	emit(this.job, {num: 1});
	}
};

var reduceFunc = function(job, num){
};

printjson(db.people.mapReduce(
	mapFunc,
	reduceFunc,
	{
	out: {inline : 1}
	}
))
