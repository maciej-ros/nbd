printjson(db.people.insert(
	{
		"sex": "Male",
		"first_name": "Maciej",
		"last_name": "Roś",
		"job": "Airport Cootdinator",
		"email": "s22776@pjwstk.edu.pl",
		"location": {
			"city": "Piaseczno",
			"address": {
				"streetname": "Kwiatowa",
				"streetnumber": "13"
			}
		},
		"description": "uwielbiam MongoDB",
		"height": "181.87",
		"weight": 79,
		"birth_date": "1997-01-23T08:21:34Z",
		"nationality": "Poland",
		"credit": [ { 
			"type": "jcb",
			"number": "0000000000000",
			"currency": "PLN",
			"balance": "-15.52"
			} ]
	}
))
