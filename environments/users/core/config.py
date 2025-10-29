import os
import secrets 
from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    app_name: str = "Users Management"
    app_version: str = "1.0.0"
    debug: bool = False
    
    port: int = 8080
    host: str = "localhost"

    database_url: str = os.getenv("DATABASE_URL", "sqlite:///./test.db")
    redis_url: str = os.getenv("REDIS_URL", "redis://localhost:6379/0")
    jwt_secret: str = os.getenv("JWT_SECRET", secrets.token_urlsafe(32))

    allowed_hosts: list = ["*"]
    cors_origins: list = ["*"]
    secret_key: str = os.getenv("SECRET_KEY", secrets.token_urlsafe(32))

    @property
    def is_production(self) -> bool:
        return not self.debug

    class Config:
        env_file = ".env"
        env_file_encoding = "utf-8"
        case_sensitive = False
        
settings = Settings()
