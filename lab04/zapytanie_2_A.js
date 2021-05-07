printjson(db.people.aggregate(
	[{ $unwind : "$credit" },
	{$addFields: {
		convertedBalance: { $convert: { input: "$credit.balance", to: "double", onError: "Error", onNull: 0}},
	}},
	{$group: {
		_id: "$credit.currency",
		avg_balance: {$avg: "$convertedBalance"},
	}}]
).toArray())
