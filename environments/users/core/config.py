import os
import secrets 
from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    app_name: str = "Users Management"
    app_version: str = "1.0.0"
    debug: bool = False
    
    port: int = 8080
    host: str = "localhost"

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
