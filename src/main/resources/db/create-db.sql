create table qdoc {
  uuid UUID,
  content VARCHAR(1024),
  type VARCHAR(50),
  UNIQUE uuid,
  PRIMARY KEY (uuid)
}