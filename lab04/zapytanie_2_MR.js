var mapFunc = function(){
	for (let j = 0; j < this.credit.length; j++) {	
		emit(this.credit[j].currency, {balance: parseFloat(this.credit[j].balance), num: 1});
	}
};

var reduceFunc = function(currency, values){
	var n = {balance: 0, num: 0};
	for (let i = 0; i < values.length; i++) {
		n.balance += values[i].balance;
		n.num += values[i].num;
	}
	return n.balance/n.num;
};



printjson(db.people.mapReduce(
	mapFunc,
	reduceFunc,
	{ out: {inline : 1}}
))
