import riak
client = riak.RiakClient(host = '172.17.0.2', pb_port=8087, protocol='pbc')
bucket = client.bucket('cw08')
doc = {
	"imie": "Maciej",
	"nazwisko": "Ros",
	"rok": 1,
	"ocena": 4.5
}

key = bucket.new('student', data=doc)
key.store()

fetched = bucket.get('student')
print(fetched.encoded_data)

fetched.data["ocena"] = 5
fetched.store()

fetched = bucket.get('student')
print(fetched.encoded_data)

fetched.delete()
fetched
