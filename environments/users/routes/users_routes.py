from fastapi import APIRouter

userRouter = APIRouter(prefix="/users", tags=["users"])


@userRouter.get("/test")
async def test():
    return {"message": "User route is working!"}