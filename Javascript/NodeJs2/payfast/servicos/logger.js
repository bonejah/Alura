var winston = require('winston');

var logger = new winston.Logger({
  transports: [
    new winston.transports.File({
      level: "info",
      filename: "logs/payfast.log",
      maxsize: 10000,
      maxFiles: 10
    })
  ]
});

logger.log('Log utilizando winston');
logger.log('info','Log utilizando winston e info');
logger.info('Log mais maroto');