printjson(db.people.aggregate(
	[{$addFields: {
		convertedWeight: { $convert: { input: "$weight", to: "double", onError: "Error", onNull: 0}},
		convertedHeight: { $convert: { input: "$height", to: "double", onError: "Error", onNull: 0}},
	}},
	{$group: {
		_id: "$sex",
		avg_weight: {$avg: "$convertedWeight"},
		avg_height: {$avg: "$convertedHeight"},
	}}]
).toArray())
