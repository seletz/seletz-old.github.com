from __future__ import with_statement

import logging
from com.ziclix.python.sql import zxJDBC

logger = logging.getLogger("nexiles.wt.demo")

def setup_logging(level=logging.DEBUG):
    logging.basicConfig(level=level, format="%(asctime)s [%(levelname)-7s] [line %(lineno)d] %(name)s: %(message)s")

def get_connection(host, port, sid, username, password):
    jdbc_url = "jdbc:oracle:thin:@%(host)s:%(port)s:%(sid)s" % locals()
    logger.debug("get_connection: jdbc_url=%s" % jdbc_url)
    driver = "oracle.jdbc.driver.OracleDriver"
    return zxJDBC.connect(jdbc_url, username, password, driver)

def update_sequence(cursor, name):
    cursor.execute("select NAME, SEQ from NXTEST where name = ? for update", [name])
    result = cursor.fetchall()
    if result:
        logger.debug("UPDATE: %s" % name)
        cursor.execute("update NXTEST set seq = seq + 1 where name = ?", [name])
    else:
        logger.debug("CREATE: %s" % name)
        cursor.execute("insert into NXTEST values (?, ?)", [name, 1])

    cursor.execute("select NAME, SEQ from NXTEST where name = ?", [name])
    result = cursor.fetchall()
    _, seq = result[0]
    logger.debug("NAME: %s => SEQ %03d" % (name, seq))
    return seq

def main():
    username = "****"
    password = "****"

    with get_connection("example.com", 1521, "orc4", username, password) as conn:
        with conn:
            logger.debug("connection: %r" % conn)
            with conn.cursor() as c:
                logger.debug("cursor: %r" % c)

                update_sequence(c, "test-foo-bar")
                update_sequence(c, "test-foo-bar")
                update_sequence(c, "test-bar-bar")
                update_sequence(c, "test-bar-bar")
                update_sequence(c, "flirz-foo-bar")
                update_sequence(c, "flirz-foo-bar")
                update_sequence(c, "flirz-foo-bar")


if __name__ == '__main__':
    setup_logging()
    main()
