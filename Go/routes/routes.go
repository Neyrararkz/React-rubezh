package routes

import (
	"go-rubezh/handlers"
	"go-rubezh/middleware"
	"github.com/gin-gonic/gin"
)

func SetupRouter() *gin.Engine {
	r := gin.New()
	r.Use(middleware.RequestLogger())
	r.Use(gin.Recovery())

	r.GET("/ping", handlers.GetPing)
	r.GET("/users", handlers.GetUsers)

	return r
}