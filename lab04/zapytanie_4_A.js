printjson(db.people.aggregate(
	[{$addFields: {
		convertedWeight: { $convert: { input: "$weight", to: "double", onError: "Error", onNull: 0}},
		convertedHeight: { $convert: { input: "$height", to: "double", onError: "Error", onNull: 0}},
	}},
	{$group: {
		_id: "$nationality",
		avg_bmi: {$avg: 
				{$divide: [ "$convertedWeight", {$multiply: ["$convertedHeight", "$convertedHeight"]}]}
				},
		min_bmi: {$min: 
				{$divide: [ "$convertedWeight", {$multiply: ["$convertedHeight", "$convertedHeight"]}]}
				},
		max_bmi: {$max: 
				{$divide: [ "$convertedWeight", {$multiply: ["$convertedHeight", "$convertedHeight"]}]}
				},
	}}]
).toArray())
