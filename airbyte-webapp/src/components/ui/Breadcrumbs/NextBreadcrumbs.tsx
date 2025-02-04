import React, { Fragment } from "react";

import styles from "./NextBreadcrumbs.module.scss";
import { FlexContainer, FlexItem } from "../Flex";
import { Link } from "../Link";
import { Text } from "../Text";

export interface NextBreadcrumbsDataItem {
  label: string;
  to?: string;
}

export interface NextBreadcrumbsProps {
  data: NextBreadcrumbsDataItem[];
}

export const NextBreadcrumbs: React.FC<NextBreadcrumbsProps> = ({ data }) => {
  return (
    <>
      {data.length && (
        <FlexContainer className={styles.container}>
          {data.map((item, index) => (
            <Fragment key={item.label}>
              <FlexItem>
                {item.to ? (
                  <Link to={item.to} className={styles.link}>
                    {item.label}
                  </Link>
                ) : (
                  <Text size="sm">{item.label}</Text>
                )}
              </FlexItem>
              {index !== data.length - 1 && <Text size="sm"> / </Text>}
            </Fragment>
          ))}
        </FlexContainer>
      )}
    </>
  );
};
