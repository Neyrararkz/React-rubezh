package middleware

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"time"
)

func RequestLogger() gin.HandlerFunc {
	return func(c *gin.Context) {
		t := time.Now()
		c.Next()
		latency := time.Since(t)
		fmt.Printf("Method: %s | Path: %s | Duration: %v\n", c.Request.Method, c.Request.URL.Path, latency)
	}
}