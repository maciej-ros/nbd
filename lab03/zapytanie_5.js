printjson(db.people.find(
	{"birth_date": {$regex: "200"}},
	{"_id": 0, "first_name": 1, "last_name": 1, "location.city": 1}
).toArray())
