import logging
import sys
import os
from datetime import datetime
from logging.handlers import TimedRotatingFileHandler
from core.config import settings

def setup_logging():
    log_level = logging.DEBUG if settings.debug else logging.INFO

    log_format = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'

    log_dir = "logs"
    if not os.path.exists(log_dir):
        os.makedirs(log_dir)
    
    current_date = datetime.now().strftime("%Y-%m-%d")
    log_filename = os.path.join(log_dir, f"app_{current_date}.log")
    
    file_handler = TimedRotatingFileHandler(
        filename=log_filename,
        when='midnight',
        interval=1,
        backupCount=30,
        encoding='utf-8'
    )
    file_handler.suffix = "%Y-%m-%d"

    logging.basicConfig(
        level=log_level,
        format=log_format,
        handlers=[
            logging.StreamHandler(sys.stdout),
            file_handler
        ]
    )

    logging.getLogger("uvicorn").setLevel(log_level)
    logging.getLogger("fastapi").setLevel(log_level)

    return logging.getLogger(__name__)

logger = setup_logging()