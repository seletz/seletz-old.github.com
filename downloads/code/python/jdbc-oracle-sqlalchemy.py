from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

from sqlalchemy import Sequence
from sqlalchemy import Table, Column, String, Integer, MetaData

from sqlalchemy.orm import mapper

url = "oracle+zxjdbc://user:pass@example.com:1521/orc4"

engine = create_engine(url, echo=True)

metadata = MetaData()
fooversions_table = Table('FooVersions', metadata,
        Column('id', Integer, Sequence('foo_version_id_seq'), primary_key=True),
        Column('name', String(50)),
        Column('seq', Integer)
        )

metadata.create_all(engine)

class FooVersions(object):
    def __init__(self, name, seq):
        self.name = name
        self.seq = seq

    def __repr__(self):
        return "<FooVersions('%s','%s')>" % (self.name, self.seq)

m = mapper(FooVersions, fooversions_table)

# Create Session class and bind it to the database
Session = sessionmaker(bind=engine)
session = Session()

session.add( FooVersions("context-foo-abc", 1) )
session.add( FooVersions("context-foo-def", 1) )
session.add( FooVersions("context-foo-ghi", 1) )

session.commit()

