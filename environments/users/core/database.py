from sqlalchemy import create_engine, event, text
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker, Session
from sqlalchemy.exc import InvalidRequestError
from typing import Generator, AsyncGenerator
import redis
import time 
import asyncio
import inspect
from functools import wraps
from starlette.concurrency import run_in_threadpool

from core.logging import logger
from core.config import settings

try:
    database_url = settings.database_url
    if not database_url:
        raise ValueError("DATABASE_URL is not set in environment variables.")
    logger.info(f"Using database URL: {database_url}")
except Exception as e:
    logger.error(f"Error retrieving database URL: {e}")
    raise

engine = create_engine(
    database_url,
    pool_size=10,
    max_overflow=5,
    pool_timeout=30,
    pool_recycle=3600,
    pool_pre_ping=True
)

SessionLocal = sessionmaker(
    expire_on_commit=False,
    bind=engine
)

Base = declarative_base()

