package com.filipovski.datasource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSourceController {

  @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> chunkedJson() {
    return ResponseEntity.ok(jsonData());
  }

  // Sufficiently long JSON data so we get at least 2 DataBuffer components
  private String jsonData() {
    return """
        [
            {
                "id": "4bf40c1c-63ff-4244-a52c-da8009bd09e0",
                "date-sample": "2023-12-01T09:16:03.717Z",
                "status-sample": "RUNNING",
                "count": 3,
                "context": [
                    {
                        "type": "someId",
                        "value": "1234"
                    }
                ],
                "messages": [
                    {
                        "id": 1,
                        "message": "Some message",
                        "category": "START"
                    },
                    {
                        "id": 1,
                        "message": "Some message",
                        "category": "END"
                    },
                    {
                        "id": 2,
                        "message": "Some message",
                        "category": "START"
                    },
                    {
                        "id": 2,
                        "message": "Some message",
                        "category": "END"
                    },
                    {
                        "id": 3,
                        "message": "Some message",
                        "category": "START"
                    },
                    {
                        "id": 3,
                        "message": "Some message",
                        "category": "END"
                    }
                ]
            },
            {
                "id": "a30a6a83-26d6-423b-93aa-f5adbc76f4be",
                "start-sample": "2023-12-01T09:14:53.386Z",
                "zustand": "RUNNING",
                "count": 3,
                "context": [
                    {
                        "type": "someId",
                        "value": "1234"
                    }
                ],
                "messages": [
                    {
                        "id": 1,
                        "message": "Some message",
                        "category": "START"
                    },
                    {
                        "id": 1,
                        "message": "Some message",
                        "category": "END"
                    },
                    {
                        "id": 2,
                        "message": "Some message",
                        "category": "START"
                    },
                    {
                        "id": 2,
                        "message": "Some message",
                        "category": "END"
                    },
                    {
                        "id": 3,
                        "message": "Some message",
                        "category": "START"
                    },
                    {
                        "id": 3,
                        "message": "Some message",
                        "category": "END"
                    }
                ]
            },
            {
                "id": "e1e20962-494f-42f5-9fe6-d2b4718e0096",
                "start-sample": "2023-12-01T09:15:55.418Z",
                "status-sample": "RUNNING",
                "count": 3,
                "context": [
                    {
                        "type": "someId",
                        "value": "1234"
                    }
                ],
                "messages": [
                    {
                        "id": 1,
                        "message": "Some message",
                        "category": "START"
                    },
                    {
                        "id": 1,
                        "message": "Some message",
                        "category": "END"
                    },
                    {
                        "id": 2,
                        "message": "Some message",
                        "category": "START"
                    },
                    {
                        "id": 2,
                        "message": "Some message",
                        "category": "END"
                    },
                    {
                        "id": 3,
                        "message": "Some message",
                        "category": "START"
                    },
                    {
                        "id": 3,
                        "message": "Some message",
                        "category": "END"
                    }
                ]
            }
        ]
        """;
  }
}
