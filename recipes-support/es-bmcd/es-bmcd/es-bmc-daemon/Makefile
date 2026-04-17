# SPDX-License-Identifier: GPL-2.0
CFLAGS ?= -O2
CFLAGS += -Wall -pthread
LDFLAGS :=  -pthread

TARGET := es-bmcd
SRCS := es-bmc-daemon.c ring.c
OBJS := $(SRCS:.c=.o)

all: $(TARGET)

$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) -o $@ $^ $(LDFLAGS)

%.o: %.c
	$(CC) $(CFLAGS) -c -o $@ $<

$(OBJS): es-bmc-daemon.h

clean:
	rm -rf $(TARGET) $(OBJS)

.PHONY: all clean
